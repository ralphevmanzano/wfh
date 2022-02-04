package com.ralphevmanzano.workoutsforhumans.home.presentation

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ralphevmanzano.workoutsforhumans.common.extensions.setImageDrawableFromString
import com.ralphevmanzano.workoutsforhumans.core.domain.model.Workout
import com.ralphevmanzano.workoutsforhumans.home.databinding.ItemWorkoutListBinding

class WorkoutsAdapter : ListAdapter<Workout, WorkoutsAdapter.WorkoutsViewHolder>(WorkoutsDiffCallback()) {

  var onItemClick: ((Workout) -> Unit)? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutsViewHolder {
    val binding = ItemWorkoutListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return WorkoutsViewHolder(binding)
  }

  override fun onBindViewHolder(holder: WorkoutsViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  inner class WorkoutsViewHolder(private val binding: ItemWorkoutListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
      onItemClick?.let {
        binding.root.setOnClickListener {
          it(getItem(adapterPosition))
        }
      }
    }

    fun bind(item: Workout) = with(binding) {
      tvWorkout.text = item.title.uppercase()
      ivWorkout.setImageDrawableFromString(item.imgRes)
    }
  }

  class WorkoutsDiffCallback : DiffUtil.ItemCallback<Workout>() {
    override fun areItemsTheSame(oldItem: Workout, newItem: Workout) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Workout, newItem: Workout) = oldItem == newItem
  }
}