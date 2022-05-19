package hu.bme.aut.android.kimiquotes.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import hu.bme.aut.android.kimiquotes.databinding.CardQuoteBinding
import hu.bme.aut.android.kimiquotes.persistence.Quote

class QuotesAdapter(private val context: Context) :
    ListAdapter<Quote, QuotesAdapter.QuoteViewHolder>(itemCallback) {

    private var quoteList = mutableListOf<Quote>()

    private var lastPosition = -1


    inner class QuoteViewHolder(binding: CardQuoteBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvText: TextView = binding.tvText
        val tvYear: TextView = binding.tvYear
        val image = binding.ivMapIcon

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = QuoteViewHolder(CardQuoteBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val tmpQuote = quoteList[position]
        holder.tvText.text = tmpQuote.quote
        holder.tvYear.text = tmpQuote.year.toString()
    }

    fun addQuote(quote: Quote?) {
        quote ?: return

        quoteList += quote
        submitList(quoteList)
    }
    companion object {
        object itemCallback : DiffUtil.ItemCallback<Quote>() {
            override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
                return oldItem == newItem
            }

        }
    }
}