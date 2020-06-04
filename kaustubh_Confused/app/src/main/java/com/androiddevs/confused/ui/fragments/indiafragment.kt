package com.androiddevs.confused.ui.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.androiddevs.confused.R
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.InputStream

lateinit var image : ImageView
lateinit var text : TextView
lateinit var loading : ProgressBar

class indiafragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root : View = inflater.inflate(R.layout.india_fragment, container, false)
        test().execute()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.imageView)
        text = view.findViewById(R.id.india_text)
        loading = view.findViewById(R.id.indiaProgressBar)
    }
}

private class test : AsyncTask<Void, Void, Void>() {

    lateinit var doc : Document
    lateinit var img : Element
    lateinit var imgSrc : String
    lateinit var input : InputStream
    lateinit var bitmap : Bitmap
    lateinit var title : String

    override fun doInBackground(vararg params: Void?): Void? {
        doc = Jsoup.connect("https://firebase.google.com/").get()
        img= doc.select("img").first()
        imgSrc = img.absUrl("src")
        input = java.net.URL(imgSrc).openStream()
        bitmap = BitmapFactory.decodeStream(input)
        title = doc.title()
        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        loading.visibility = View.GONE
        text.text = title
        image.setImageBitmap(bitmap)
    }
}

