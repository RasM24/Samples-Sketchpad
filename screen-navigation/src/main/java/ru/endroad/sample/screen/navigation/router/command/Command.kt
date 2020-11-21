package ru.endroad.sample.screen.navigation.router.command

import ru.endroad.sample.screen.navigation.router.destination.Destination

sealed class Command {

    class Open(val destination: Destination) : Command()
    class Replace(val destination: Destination) : Command()
    class ChangeRoot(val destination: Destination) : Command()
}