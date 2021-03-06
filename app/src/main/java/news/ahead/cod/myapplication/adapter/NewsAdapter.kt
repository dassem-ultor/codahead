package news.ahead.cod.myapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_view_holder.view.*
import news.ahead.cod.myapplication.R
import news.ahead.cod.myapplication.extensions.loadImageRoundedCorners
import news.ahead.cod.myapplication.model.Article

class NewsAdapter(private val list: MutableList<Article>,
                  private val itemClickHandler: (Article) -> Unit) :
        RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.news_view_holder, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = list[position]
        holder.itemView.newsViewHolder_title.text = article.title
        holder.itemView.newsViewHolder_image.loadImageRoundedCorners(article.urlToImage)
        holder.itemView.newsViewHolder_description.text = article.description
        holder.itemView.setOnClickListener { itemClickHandler(article) }
    }

    fun appendItems(list: List<Article>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
