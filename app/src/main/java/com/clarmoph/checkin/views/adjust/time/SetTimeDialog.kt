package com.clarmoph.checkin.views.adjust.time

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.clarmoph.checkin.R

class SetTimeDialog : DialogFragment() {

    companion object {
        fun newInstance() = SetTimeDialog()
    }

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.dialog_time, null))

            builder.setPositiveButton(
                R.string.ok
            ) { _, id ->
                if (id == DialogInterface.BUTTON_POSITIVE) {
                    dismiss()
                }
            }
                .setNegativeButton(
                    R.string.cancel
                ) { _, id ->
                    if (id == DialogInterface.BUTTON_NEGATIVE) {
                        dismiss()
                    }
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}