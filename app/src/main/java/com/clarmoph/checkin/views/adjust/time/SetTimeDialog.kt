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
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)

            // Dialog visual content
            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.dialog_set_time, null))

            // Dialog textual content
            builder.setPositiveButton(
                R.string.ok
            ) { _, id ->
                if (id == DialogInterface.BUTTON_POSITIVE) {
                    // TODO: SET UP POSITIVE BUTTON FUNCTIONALITY
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
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}