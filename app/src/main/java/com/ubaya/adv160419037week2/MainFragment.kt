package com.ubaya.adv160419037week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    var number1 : Int = 0
    var number2 : Int = 0
    var score: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RandomizeQuestion()
        btnSubmit.setOnClickListener {
            var answer = if (textInputAnswer.text.toString() == "") 0 else Integer.parseInt(textInputAnswer.text.toString())

            if (answer == (number1 + number2)) {
                score++
                RandomizeQuestion()
                textInputAnswer.text?.clear()
            }
            else{
                // Dapatkan action yang ingin dijalankan
                val action = MainFragmentDirections.actionResultFragment(score)

                // Jalankan actionnya
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun RandomizeQuestion(){
        number1 = (1..50).random()
        number2 = (1..50).random()

        textQuestion.text = "$number1  +  $number2"
    }
}