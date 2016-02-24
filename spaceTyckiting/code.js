/*
 * Global variables
 *
 * MAP_SIZE - map size in hexagons
 *
 * Ship properties
 *
 * x - Horizontal position on grid
 * y - Vertical position on grid
 *
 * Ship methods
 *
 * shoot(x, y) - Shoots a missile to position
 * radar(x, y) - Sends a radar pulse to given coordinates
 * move(x, y) - Moves the bot by given x, y values
 *  - maximum of 2 hexagons / direction per round
 *
 * Events
 *
 * [{
 *   type: String
 *   data: {x: Int, y: Int}
 * }]
 *
 * Event types
 *
 * 'see' - Enemy spotted right next to your ship
 * 'echo' - Enemy spotted by radar echo
 */
lastSpottedSign = -1
lastSpottedRound = 1
lastSpottedRadius = Math.atan(-1/1.5)

function updateRadius(roundId, updateSign) {
  radius = lastSpottedRadius + (roundId - lastSpottedRound) * 0.45
  if (radius > 1.57) {
    radius = - 3.14 + radius
    if (updateSign) {
      lastSpottedSign *= -1
    }
  }
  return radius 
}

function xFromRadar(roundId) {
  distanceToEnemy = 6
  radius = updateRadius(roundId, true)
  return lastSpottedSign * Math.floor(Math.cos(radius) * distanceToEnemy)
}

function yFromRadar(roundId) {
  distanceToEnemy = 6
  radius = updateRadius(roundId, false)
  return lastSpottedSign * Math.floor(Math.sin(radius) * distanceToEnemy)
}

function updateSpotted(roundId, ship, events) {
  lastSpottedRadius = Math.atan((ship.y - events[0].data.y) / (events[0].data.x - ship.x))
  lastSpottedSign = events[0].data.x > ship.x ? 1 : -1
  lastSpottedRound = roundId
}

function makeDecision(roundId, ship, events) {
  if (events.length == 0) { 
  	return ship.radar(ship.x + xFromRadar(roundId), ship.y - yFromRadar(roundId))
  }
  updateSpotted(roundId, ship, events)
  return ship.shoot(events[0].data.x, events[0].data.y)
} 
