package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var conv: Button=findViewById(R.id.button)
        var res: TextView=findViewById(R.id.textView)
        var num: EditText=findViewById(R.id.editTextNumber)
        var flag : String = "JOD to USD"

        val spinnerVal : Spinner = findViewById(R.id.spinner)
        var options = arrayOf("JOD to USD","JOD to CAD","JOD to EUR","JOD to SAR")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        conv.setOnClickListener{
            var x = num.text.toString().toFloat()

            if(flag=="JOD to USD"){
                res.text= jodToUSD(x).toString()
            }
            else if(flag=="JOD to CAD"){
                res.text= jodToCAD(x).toString()
            }
            else if(flag=="JOD to EUR"){
                res.text= jodToEUR(x).toString()
            }
            else if(flag=="JOD to SAR"){
                res.text= jodToSAR(x).toString()
            }
            else{
                res.text= "invalid input"
            }
        }

        }
}

public fun jodToUSD(num: Float): Double{
    return num*1.41;
}
public fun jodToCAD(num: Float): Double{
    return num*1.76;
}
public fun jodToEUR(num: Float): Double{
    return num*1.27;
}
public fun jodToSAR(num: Float): Double{
    return num*5.29;
}
