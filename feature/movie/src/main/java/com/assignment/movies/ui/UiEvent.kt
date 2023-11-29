package com.assignment.movies.ui

sealed interface UiEvent {
    data object InitState : UiEvent
}
