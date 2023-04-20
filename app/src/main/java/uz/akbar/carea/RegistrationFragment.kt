package uz.akbar.carea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.akbar.carea.databinding.ActivityMainBinding
import uz.akbar.carea.databinding.FragmentRegistrationBinding
import uz.akbar.carea.model.Use


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RegistrationFragment : Fragment() {
    private var userList = mutableListOf<Use>()


    lateinit var main_binding: ActivityMainBinding
    lateinit var binding: FragmentRegistrationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout {
        main_binding = ActivityMainBinding.inflate(inflater, container, false)
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)



        val shared = requireContext().getSharedPreferences("shared", AppCompatActivity.MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<Use>>() {}.type

        binding.signUp.setOnClickListener {

            var users = shared.getString("users", "")
            if (users == "") {
                userList = mutableListOf()
            } else {
                userList = gson.fromJson(users, convert)
            }

            var user = Use(
                binding.email.text.toString(),
                binding.password.text.toString(),)

            if (validate()) {
                userList.add(user)


                val str = gson.toJson(userList)
                edit.putString("users", str).apply()


                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, HomeFragment())
                    .commit()
                shared.edit().putString("active_user", gson.toJson(user)).apply()
            }
        }
        return binding.root
    }

        private fun validate(): Boolean {
            if (binding.email.text.toString().isEmpty() || binding.password.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Fill the gaps", Toast.LENGTH_SHORT).show()
                return false
            }

            for (i in userList.indices) {
                if (binding.email.text.toString() == userList[i].email) {
                    Toast.makeText(requireContext(), "User with this username already registered", Toast.LENGTH_SHORT).show()
                    return false
                }
            }

            return true
        }


    }