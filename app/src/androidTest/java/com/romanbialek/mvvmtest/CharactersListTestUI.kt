package com.romanbialek.mvvmtest

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import com.romanbialek.mvvmtest.presentation.characterlist.CharactersListActivity
import com.romanbialek.mvvmtest.presentation.characterlist.CharactersListAdapter
import androidx.test.espresso.intent.Intents
import com.romanbialek.mvvmtest.domain.model.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CharactersListActivityTest {

    @Test
    fun charactersListDataMatches() {

        Intents.init()
        val activityScenario: ActivityScenario<CharactersListActivity> =
            ActivityScenario.launch(CharactersListActivity::class.java)
        activityScenario.onActivity { activity ->

            val list: RecyclerView? = activity?.getRecycleView()

            //checks if recycleview exists
            assertNotNull("Intent was null", list)

            val adapter = CharactersListAdapter(activity)
            list!!.adapter = adapter

            adapter.addData(0, createData())
            adapter.notifyDataSetChanged()

            //checks list's adapter item counts equals to provided data
            assertEquals(2, list.adapter?.itemCount)

            //check if adapter data matches the input
            val secondName = adapter.getItem(1).name
            assertEquals("Spiderman", secondName)

        }

        Intents.release()
    }

    private fun createData(): List<Character> {
        val characters: ArrayList<Character> = ArrayList()
        val character = Character(
            id = 1,
            name = "Batman",
            description = "lorem itsum confutatis flemni ",
            modified = "",
            thumbnail = CharacterThumbnail(path= "", extension = ""),
            resourceURI = "",
            comicsResponse = ComicsResponse(available = 3),
            seriesResponse = SeriesResponse(available = 2),
            eventsResponse = EventsResponse(available = 1),
            storiesResponse = StoriesResponse(available = 0)

        )
        characters.add(character)
        val character2 = Character(
            id = 1,
            name = "Spiderman",
            description = "lorem itsum confutatis flemni ",
            modified = "",
            thumbnail = CharacterThumbnail(path= "", extension = ""),
            resourceURI = "",
            comicsResponse = ComicsResponse(available = 3),
            seriesResponse = SeriesResponse(available = 2),
            eventsResponse = EventsResponse(available = 1),
            storiesResponse = StoriesResponse(available = 0)

        )
        characters.add(character2)
        return characters
    }
}