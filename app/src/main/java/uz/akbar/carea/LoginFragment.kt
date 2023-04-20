package uz.akbar.carea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.akbar.carea.databinding.ActivityMainBinding
import uz.akbar.carea.databinding.FragmentLoginBinding
import uz.akbar.carea.model.Use


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LoginFragment : Fragment() {
    private var userList = mutableListOf<Use>()


    lateinit var main_binding: ActivityMainBinding
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        main_binding = ActivityMainBinding.inflate(inflater, container, false)
        val shared = requireContext().getSharedPreferences("shared", AppCompatActivity.MODE_PRIVATE)

        val gson = Gson()
        val convert = object : TypeToken<List<Use>>() {}.type
        val users = shared.getString("users", "")

        binding.signIn.setOnClickListener {

            if (users != "") {
                userList = gson.fromJson(users, convert)
            }
            for (user in userList) {
                if ((binding.email.text.toString() == user.email) && binding.password.text.toString() == user.password) {
                    Toast.makeText(requireContext(), "Successfully logged in", Toast.LENGTH_SHORT)
                        .show()

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, HomeFragment())
                        .commit()

                }
            }
        }
        binding.signUp.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, RegistrationFragment())
                .commit()
        }
        return binding.root
    }

}