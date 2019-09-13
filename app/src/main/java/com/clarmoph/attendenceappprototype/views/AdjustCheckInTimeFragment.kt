package com.clarmoph.attendenceappprototype.views

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.clarmoph.attendenceappprototype.R
import com.clarmoph.attendenceappprototype.viewmodels.CheckInTimeViewModel
import kotlinx.android.synthetic.main.adjust_check_in_time_fragment.*


class AdjustCheckInTimeFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    companion object {
        fun newInstance() = AdjustCheckInTimeFragment()
    }

    private val MONTHS = arrayOf(
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep",
        "Oct",
        "Nov",
        "Dec"
    )
    private lateinit var viewModel: CheckInTimeViewModel
    private var TAG = AdjustCheckInTimeFragment::class.java.name

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.adjust_check_in_time_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CheckInTimeViewModel::class.java)
        btn_checkin_date.setOnClickListener { showDateFragment() }
    }

    private fun showDateFragment() {
        val datePickerDialog = DatePickerDialog(activity!!)
        datePickerDialog.setOnDateSetListener(this)
        datePickerDialog.show()
    }


    override fun onDateSet(datePicker: DatePicker?, years: Int, months: Int, days: Int) {
        // TODO : Update date property LiveData
        swapViewVisibility(years, months, days)
    }

    private fun swapViewVisibility(years: Int, months: Int, days: Int) {
        btn_checkin_date.visibility = View.INVISIBLE
        from_date.visibility = View.VISIBLE
        from_date_calender.visibility = View.VISIBLE
        from_date_calender.text = getString(R.string.from_time, MONTHS[months], days)

        to_date.visibility = View.VISIBLE
        to_date_calender.visibility = View.VISIBLE
        to_date_calender.text = getString(R.string.to_time, MONTHS[months], days)
    }

}
