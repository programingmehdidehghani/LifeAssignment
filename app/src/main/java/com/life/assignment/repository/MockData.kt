package com.life.assignment.repository

import com.life.assignment.data.Author

enum class AuthorEnum(val firstName: String, val lastName: String) {
    Alejandro("Alejandro", "Escamilla"),
    Paul("Paul", "Jarvis"),
    Aleks("Aleks", "Dorohovich"),
    Vadim("Vadim", "Sherbakov"),
    Yoni("Yoni", "Kaplan-Nadel"),
    Jerry("Jerry", "Adney"),
    John("John", "smith")
}

fun AuthorEnum.build(): Author {
    return Author((firstName + lastName).hashCode(), firstName, lastName)
}

fun AuthorEnum.imageUrl(): List<String> {
    return when (this) {
        AuthorEnum.Alejandro ->
            listOf(
                "https://picsum.photos/id/0/5000/3333",
                "https://picsum.photos/id/1/5000/3333",
                "https://picsum.photos/id/2/5000/3333",
                "https://picsum.photos/id/3/5000/3333"
            )
        AuthorEnum.Paul ->
            listOf(
                "https://picsum.photos/id/10/2500/1667",
                "https://picsum.photos/id/11/2500/1667",
                "https://picsum.photos/id/12/2500/1667",
                "https://picsum.photos/id/13/2500/1667"
            )
        AuthorEnum.Aleks ->
            listOf(
                "https://picsum.photos/id/20/3670/2462",
                "https://picsum.photos/id/21/3008/2008",
                "https://picsum.photos/id/22/4434/3729",
                "https://picsum.photos/id/23/3887/4899"
            )
        AuthorEnum.Vadim ->
            listOf(
                "https://picsum.photos/id/24/4855/1803",
                "https://picsum.photos/id/25/5000/3333",
                "https://picsum.photos/id/26/4209/2769",
                "https://picsum.photos/id/19/2500/1667"
            )
        AuthorEnum.Yoni ->
            listOf(
                "https://picsum.photos/id/27/3264/1836",
                "https://picsum.photos/id/15/2500/1667",
                "https://picsum.photos/id/16/2500/1667",
                "https://picsum.photos/id/17/2500/1667",
            )
        AuthorEnum.Jerry ->
            listOf(
                "https://picsum.photos/id/28/4928/3264",
                "https://picsum.photos/id/5/5000/3334",
                "https://picsum.photos/id/6/5000/3333",
                "https://picsum.photos/id/7/4728/3168",
            )
        AuthorEnum.John ->
            listOf(
                "https://picsum.photos/id/29/4000/2670",
                "https://picsum.photos/id/9/5000/3269",
                "https://picsum.photos/id/4/5000/3333",
                "https://picsum.photos/id/14/2500/1667"
            )
    }
}
