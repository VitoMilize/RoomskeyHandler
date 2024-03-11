package com.example.roomskeyhandler

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.roomskeyhandler.models.ChangeProfileRequest
import com.example.roomskeyhandler.models.ChangeProfileResponse
import com.example.roomskeyhandler.models.GiveKeyRequest
import com.example.roomskeyhandler.models.Key
import com.example.roomskeyhandler.models.LoginRequest
import com.example.roomskeyhandler.models.LoginResponse
import com.example.roomskeyhandler.models.ProfileResponse
import com.example.roomskeyhandler.models.RegistrationRequest
import com.example.roomskeyhandler.models.RegistrationResponse
import com.example.roomskeyhandler.models.ScheduleBlock
import com.example.roomskeyhandler.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GeneralViewModel(private val tokenStore: TokenStore): ViewModel() {
    private val _nameRegistration = MutableStateFlow("")
    val nameRegistration = _nameRegistration.asStateFlow()
    private val _phoneRegistration = MutableStateFlow("")
    val phoneRegistration = _phoneRegistration.asStateFlow()
    private val _passwordRegistration = MutableStateFlow("")
    val passwordRegistration = _passwordRegistration.asStateFlow()
    private val _passwordRepeatRegistration = MutableStateFlow("")
    val passwordRepeatRegistration = _passwordRepeatRegistration.asStateFlow()
    private val _registrationResponseError = MutableStateFlow<Boolean?>(null)
    val registrationResponseError = _registrationResponseError.asStateFlow()
    private val _registrationResponse = MutableStateFlow<RegistrationResponse?>(null)
    val registrationResponse = _registrationResponse.asStateFlow()
    private val _phoneLogin = MutableStateFlow("")
    val phoneLogin = _phoneLogin.asStateFlow()
    private val _passwordLogin = MutableStateFlow("")
    val passwordLogin = _passwordLogin.asStateFlow()
    private val _loginResponseError = MutableStateFlow<Boolean?>(null)
    val loginResponseError = _loginResponseError.asStateFlow()
    private val _loginResponse = MutableStateFlow<LoginResponse?>(null)
    val loginResponse = _loginResponse.asStateFlow()
    private val _nameProfile = MutableStateFlow("")
    val nameProfile = _nameProfile.asStateFlow()
    private val _phoneProfile = MutableStateFlow("")
    val phoneProfile = _phoneProfile.asStateFlow()
    private val _emailProfile = MutableStateFlow("")
    val emailProfile = _emailProfile.asStateFlow()
    private val _avatarLinkProfile = MutableStateFlow("")
    val avatarLinkProfile = _avatarLinkProfile.asStateFlow()
    private val _changeProfileResponse = MutableStateFlow<ChangeProfileResponse?>(null)
    val changeProfileResponse = _changeProfileResponse.asStateFlow()
    private val _profileResponse = MutableStateFlow<ProfileResponse?>(null)
    val profileResponse = _profileResponse.asStateFlow()
    private val _myKeys = MutableStateFlow<List<Key>>(emptyList())
    val myKeys = _myKeys.asStateFlow()
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users = _users.asStateFlow()
    private val _userForKey = MutableStateFlow<User?>(null)
    val userForKey = _userForKey.asStateFlow()
    private val _expanded = MutableStateFlow(false)
    val expanded = _expanded.asStateFlow()
    private val _schedule = MutableStateFlow(generateMatrix(30, 7))
    val schedule = _schedule.asStateFlow()
    private val _scheduleBlock = MutableStateFlow<List<ScheduleBlock>>(emptyList())
    val scheduleBlock = _scheduleBlock.asStateFlow()
    private val _date = MutableStateFlow("")
    val date = _date.asStateFlow()
    private val _time = MutableStateFlow("")
    val time = _time.asStateFlow()

    private fun generateMatrix(rows: Int, columns: Int): MutableList<MutableList<MutableList<Int>>> {
        val matrix = mutableListOf<MutableList<MutableList<Int>>>()
        for (i in 0 until rows) {
            val row = mutableListOf<MutableList<Int>>()
            for (j in 0 until columns) {
                row.add(mutableListOf())
            }
            matrix.add(row)
        }
        return matrix
    }

    fun setDate(text: String) {
        _date.value = text
    }
    fun setTime(text: String) {
        _time.value = text
    }

    fun setPhoneLogin(text: String) {
        _phoneLogin.value = text
    }
    fun setPasswordLogin(text: String) {
        _passwordLogin.value = text
    }

    fun setNameRegistration(text: String) {
        _nameRegistration.value = text
    }

    fun setPhoneRegistration(text: String) {
        _phoneRegistration.value = text
    }
    fun setPasswordRegistration(text: String) {
        _passwordRegistration.value = text
    }

    fun setPasswordRepeatRegistration(text: String) {
        _passwordRepeatRegistration.value = text
    }

    fun setNameProfile(text: String) {
        _nameProfile.value = text
    }

    fun setPhoneProfile(text: String) {
        _phoneProfile.value = text
    }
    fun setEmailProfile(text: String) {
        _emailProfile.value = text
    }

    fun setAvatarLinkProfile(text: String) {
        _avatarLinkProfile.value = text
    }

    fun changeExpanded() {
        _expanded.value = !_expanded.value
    }

    fun setUserForKey(user: User) {
        _userForKey.value = user
    }

    fun clearRegistrationResponseErrorState() {
        _registrationResponseError.value = null
    }

    fun clearLoginResponseErrorState() {
        _loginResponseError.value = null
    }

    fun onDeclineChangesClick() {
        getProfile()
    }

    fun onLogoutClick() {
        logout()
    }

    fun onGiveKey(userId: Int, keyId: Int) {
        giveKey(userId, keyId)
    }

    fun onSaveProfileClick() {
        changeProfile(
            ChangeProfileRequest(
                name = _nameProfile.value,
                phone = _phoneProfile.value,
                email = _emailProfile.value,
                avatarLink = _avatarLinkProfile.value
            )
        )
    }

    fun onRegistrationClick() {
        registration(
            RegistrationRequest(
                name = _nameRegistration.value,
                phone = _phoneRegistration.value,
                password = _passwordRegistration.value
            )
        )
    }

    fun onLoginClick() {
        login(
            LoginRequest(
                phone = _phoneLogin.value,
                password = _passwordLogin.value
            )
        )
    }


    private fun logout() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.keysAPIService.logout("Bearer ${tokenStore.getToken()}")
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    200 -> {
                        tokenStore.clearToken()
                        Log.e("CHECK", tokenStore.getToken().toString())
                    }
                    400 ->{
                        Log.e("ERROR", "400")
                    }
                    401 ->{
                        Log.e("ERROR", "401")
                    }
                    403 ->{
                        Log.e("ERROR", "403")
                    }
                }
            }
        }
    }

    fun getProfile() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.keysAPIService.getProfile("Bearer ${tokenStore.getToken()}")
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    200 -> {
                        _profileResponse.value = response.body()
                        _nameProfile.value = _profileResponse.value!!.name
                        _phoneProfile.value = _profileResponse.value!!.phone
                        if (_profileResponse.value?.email == null) _emailProfile.value = ""
                        else _emailProfile.value = _profileResponse.value!!.email.toString()
                        if (_profileResponse.value?.avatarLink == null) _avatarLinkProfile.value = ""
                        else _avatarLinkProfile.value = _profileResponse.value!!.avatarLink.toString()
                    }
                    400 ->{
                        Log.e("ERROR", "400")
                    }
                    401 ->{
                        Log.e("ERROR", "401")
                    }
                    403 ->{
                        Log.e("ERROR", "403")
                    }
                }
            }
        }
    }

    private fun registration(registrationRequest: RegistrationRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.keysAPIService.registration(registrationRequest)
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    201 -> {
                        _registrationResponse.value = response.body()
                        tokenStore.saveToken(_registrationResponse.value!!.token)
                        getProfile()
                        getMyKeys()
                    }
                    400 -> {
                        _registrationResponseError.value = true
                    }
                }
            }
        }
    }

    private fun login(loginRequest: LoginRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.keysAPIService.login(loginRequest)
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    200 -> {
                        _loginResponse.value = response.body()
                        tokenStore.saveToken(_loginResponse.value!!.token)
                        getProfile()
                        getMyKeys()
                    }
                    400 ->{
                        _loginResponseError.value = true
                    }
                }
            }
        }
    }

    private fun changeProfile(changeProfileRequest: ChangeProfileRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.keysAPIService.changeProfile(changeProfileRequest, "Bearer ${tokenStore.getToken()}")
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    200 -> {
//                            getProfile()
                    }
                }
            }
        }
    }

    fun getMyKeys() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.keysAPIService.getMyKeys("Bearer ${tokenStore.getToken()}", 10000)
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    200 -> {
                        if (response.body()!!.keys == null) {
                            _myKeys.value = emptyList()
                        } else {
                            _myKeys.value = response.body()!!.keys!!
                        }
                    }
                }
            }
        }
    }

    fun giveKey(userId: Int, keyId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.keysAPIService.giveKey("Bearer ${tokenStore.getToken()}", keyId, GiveKeyRequest(userId))
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    200 -> {
                        getMyKeys()
                        getUsers()
                        _userForKey.value = _users.value[0]
                    }
                }
            }
        }
    }

    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.keysAPIService.getUsers("Bearer ${tokenStore.getToken()}", 10000)
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    200 -> {
                        _users.value = response.body()!!.users
                        _userForKey.value = _users.value[0]
                    }
                }
            }
        }
    }

    fun getScheduleBlock() {
        CoroutineScope(Dispatchers.IO).launch() {
            val response = RetrofitClient.keysAPIService.getScheduleBlock("Bearer ${tokenStore.getToken()}", _time.value, _date.value)
            withContext(Dispatchers.Main) {
                when(response.code()) {
                    200 -> {
                        if (response.body()!!.keys != null) {
                            _scheduleBlock.value = response.body()!!.keys!!
                        }
                    }
                }

            }
        }
    }
}