package com.example.redditclone.topics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.redditclone.R
import com.example.redditclone.databinding.TopicItemViewBinding
import com.example.redditclone.models.Topic

class TopicsAdapter(
    private val onUpVoteClicked: (id: Int) -> Unit,
    private val onDownVoteClicked: (id: Int) -> Unit
) : RecyclerView.Adapter<TopicsAdapter.ViewHolder>() {

    private val TopicsList = ArrayList<Topic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.topic_item_view, parent, false
            ),
            onUpVoteClicked,
            onDownVoteClicked
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(TopicsList[position])
    }

    fun setData(list: List<Topic>) {
        this.TopicsList.clear()
        this.TopicsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = TopicsList.size

    class ViewHolder(
        private val viewBinding: TopicItemViewBinding,
        onUpVoteClicked: (id: Int) -> Unit,
        onDownVoteClicked: (id: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(viewBinding.root) {

        init {
            viewBinding.upVote.setOnClickListener {
                onUpVoteClicked(viewBinding.topic?.id!!)
            }
            viewBinding.downVote.setOnClickListener {
                onDownVoteClicked(viewBinding.topic?.id!!)
            }
        }

        fun bind(topic: Topic) {
            viewBinding.topic = topic
        }
    }
}