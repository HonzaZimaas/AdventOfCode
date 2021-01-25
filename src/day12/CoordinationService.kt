package day12

import day12.Coordination.DirectType

class CoordinationService(private val coordinations: List<Coordination>) {
    private var currentFacingValue = 0
    private var northOrSouthDistance = 0
    private var eastOrWestDistance = 0
    private var facingDirect = DirectType.EAST

    fun navigateAccordingToCoordination() {
        coordinations.forEach { coordination ->
            if (coordination.direct == DirectType.LEFT || coordination.direct == DirectType.RIGHT) {
                currentFacingValue = changeShipFacing(coordination)
            }
            if (coordination.direct in listOf(DirectType.EAST, DirectType.SOUTH, DirectType.WEST, DirectType.NORTH)) {
                countDirectDistance(coordination, coordination.direct)
            }
            if (coordination.direct == DirectType.FORWARD) {
                countDirectDistance(coordination, facingDirect)
            }
            println("Facing: $facingDirect : $northOrSouthDistance, $eastOrWestDistance")
        }
    }

    private fun changeShipFacing(coordination: Coordination): Int {
        var newFacing =
            if (coordination.direct == DirectType.RIGHT) currentFacingValue + coordination.rotationDegree!!
            else currentFacingValue - coordination.rotationDegree!!

        if (newFacing > 3) {
            newFacing -= 4
        }
        if (newFacing < 0) {
            newFacing += 4
        }

        facingDirect = getFacingInDirectType(newFacing)
        return newFacing
    }

    private fun getFacingInDirectType(shipFacing: Int): DirectType {
        when (shipFacing) {
            0 -> return DirectType.EAST
            1 -> return DirectType.SOUTH
            2 -> return DirectType.WEST
            3 -> return DirectType.NORTH
        }
        throw IllegalStateException("This will never happend: $shipFacing")
    }

    private fun countDirectDistance(coordination: Coordination, direct: DirectType) {
        if (direct == DirectType.EAST) {
            eastOrWestDistance += coordination.distance
        }
        if (direct == DirectType.SOUTH) {
            northOrSouthDistance += coordination.distance
        }
        if (direct == DirectType.WEST) {
            eastOrWestDistance -= coordination.distance
        }
        if (direct == DirectType.NORTH) {
            northOrSouthDistance -= coordination.distance
        }
    }
}