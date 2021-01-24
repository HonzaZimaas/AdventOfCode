package day12

import day12.Coordination.*
import java.lang.IllegalStateException

class CoordinationService(private val coordinations: List<Coordination>) {
    private var currentFacingValue = 0
    private var rovne = 0
    private var podelne = 0
    private var facingDirect = DirectType.EAST

    fun navigate() {
        coordinations.forEach { coordination ->
            if (coordination.direct == DirectType.LEFT || coordination.direct == DirectType.RIGHT) {
                currentFacingValue = checkDirection(coordination)
            }
            if (coordination.direct in listOf(DirectType.WEST, DirectType.EAST, DirectType.SOUTH, DirectType.NORTH)) {
                tujemetoda(coordination)
            }
            if (coordination.direct == DirectType.FORWARD) {
                if (facingDirect == DirectType.EAST) {
                    podelne += coordination.distance
                }
                if (facingDirect == DirectType.SOUTH) {
                    rovne += coordination.distance
                }
                if (facingDirect == DirectType.WEST) {
                    podelne -= coordination.distance
                }
                if (facingDirect == DirectType.NORTH) {
                    rovne -= coordination.distance
                }
            }
            println("Facing: $facingDirect : $rovne, $podelne")
        }
    }

    private fun checkDirection(coordination: Coordination): Int {
        val nextDirect = coordination.distance / 90
        var newFacing = if (coordination.direct == DirectType.RIGHT) currentFacingValue + nextDirect else currentFacingValue - nextDirect

        if (newFacing > 3) {
            newFacing -= 3
        }
        if (newFacing < 0) {
            newFacing += 4
        }

        facingDirect = getFacingInDirect(newFacing)
        return newFacing
    }

    private fun getFacingInDirect(int: Int): DirectType {
        when (int) {
            0 -> return DirectType.EAST
            1 -> return DirectType.SOUTH
            2 -> return DirectType.WEST
            3 -> return DirectType.NORTH
        }
        throw IllegalStateException("")
    }

    private fun tujemetoda(coordination: Coordination) {
        if (coordination.direct == DirectType.EAST) {
            podelne += coordination.distance
        }
        if (coordination.direct == DirectType.SOUTH) {
            rovne += coordination.distance
        }
        if (coordination.direct == DirectType.WEST) {
            podelne -= coordination.distance
        }
        if (coordination.direct == DirectType.NORTH) {
            rovne -= coordination.distance
        }
    }
}