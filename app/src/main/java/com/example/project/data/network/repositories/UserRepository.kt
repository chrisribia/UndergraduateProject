package com.example.project.data.network.repositories

import com.example.project.data.network.MyApi
import com.example.project.data.network.SafeApiRequest

class UserRepository( private val api: MyApi): SafeApiRequest() {
}