package com.bchmsl.homework6

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import com.bchmsl.homework6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val users = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        listeners()
    }

    private fun listeners() {
        binding.btnAdd.setOnClickListener {
            if (checkFields(
                    binding.etFirstName.text,
                    binding.etLastName.text,
                    binding.etEmail.text,
                    binding.etAge.text
                )
            ) {
                try {
                    val user = User(
                        binding.etFirstName.text.toString(),
                        binding.etLastName.text.toString(),
                        binding.etEmail.text.toString(),
                        binding.etAge.text.toString().toInt()
                    )
                    addUser(user)
                } catch (e: Exception) {
                    binding.tvStatus.apply {
                        text = context.getString(R.string.check_fields)
                        visibility = View.VISIBLE
                        setTextColor(Color.RED)
                    }
                }
            } else {
                binding.tvStatus.apply {
                    text = context.getString(R.string.check_fields)
                    visibility = View.VISIBLE
                    setTextColor(Color.RED)
                }
            }
        }
        binding.btnUpdate.setOnClickListener {
            if (checkFields(
                    binding.etFirstName.text,
                    binding.etLastName.text,
                    binding.etEmail.text,
                    binding.etAge.text
                )
            ) {
                try {
                    val user = User(
                        binding.etFirstName.text.toString(),
                        binding.etLastName.text.toString(),
                        binding.etEmail.text.toString(),
                        binding.etAge.text.toString().toInt()
                    )
                    updateUser(user)
                } catch (e: Exception) {
                    binding.tvStatus.apply {
                        text = context.getString(R.string.check_fields)
                        visibility = View.VISIBLE
                        setTextColor(Color.RED)
                    }
                }
            } else {
                binding.tvStatus.apply {
                    text = context.getString(R.string.check_fields)
                    visibility = View.VISIBLE
                    setTextColor(Color.RED)
                }
            }
        }
        binding.btnRemove.setOnClickListener {
            if (checkFields(
                    binding.etFirstName.text,
                    binding.etLastName.text,
                    binding.etEmail.text,
                    binding.etAge.text
                )
            ) {
                try {
                    val user = User(
                        binding.etFirstName.text.toString(),
                        binding.etLastName.text.toString(),
                        binding.etEmail.text.toString(),
                        binding.etAge.text.toString().toInt()
                    )
                    removeUser(user)
                } catch (e: Exception) {
                    binding.tvStatus.apply {
                        text = context.getString(R.string.check_fields)
                        visibility = View.VISIBLE
                        setTextColor(Color.RED)
                    }
                }
            } else {
                binding.tvStatus.apply {
                    text = context.getString(R.string.check_fields)
                    visibility = View.VISIBLE
                    setTextColor(Color.RED)
                }
            }

        }
    }


    private fun addUser(user: User) {
        if (users.isEmpty()) {
            users.add(user)
            d("TAG-added", users.toString())
            binding.tvStatus.apply {
                text = context.getString(R.string.success)
                visibility = View.VISIBLE
                setTextColor(Color.GREEN)
            }
        } else {
            users.forEach { it ->
                if (user.email == it.email) {
                    d("TAG-add-error", users.toString())
                    binding.tvStatus.apply {
                        text = context.getString(R.string.exists)
                        visibility = View.VISIBLE
                        setTextColor(Color.RED)
                    }
                    return
                } else {
                    users.add(user)
                    d("TAG-added", users.toString())
                    binding.tvStatus.apply {
                        text = context.getString(R.string.success)
                        visibility = View.VISIBLE
                        setTextColor(Color.GREEN)
                    }
                }
            }
        }
    }

    private fun updateUser(user: User) {
        users.forEach {
            if (it.email == user.email) {
                users[users.indexOf(it)] = user
                d("TAG-updated", users.toString())
                binding.tvStatus.apply {
                    text = context.getString(R.string.updated)
                    visibility = View.VISIBLE
                    setTextColor(Color.GREEN)
                }
                return
            } else if (it.firstName == user.firstName
                && it.lastName == user.lastName
                && it.age == user.age
            ) {
                users[users.indexOf(it)] = user
                d("TAG-updated", users.toString())
                binding.tvStatus.apply {
                    text = context.getString(R.string.updated)
                    visibility = View.VISIBLE
                    setTextColor(Color.GREEN)
                }
                return
            } else {
                binding.tvStatus.apply {
                    text = context.getString(R.string.not_found)
                    visibility = View.VISIBLE
                    setTextColor(Color.RED)
                }
            }
        }
    }

    private fun removeUser(user: User) {
        users.forEach {
            if (it == user) {
                users.removeAt(users.indexOf(it))
                d("TAG-removed", users.toString())
                binding.tvStatus.apply {
                    text = context.getString(R.string.removed)
                    visibility = View.VISIBLE
                    setTextColor(Color.GREEN)
                }
                return
            } else {
                binding.tvStatus.apply {
                    text = context.getString(R.string.not_found)
                    visibility = View.VISIBLE
                    setTextColor(Color.RED)
                }
            }
        }
    }
}
