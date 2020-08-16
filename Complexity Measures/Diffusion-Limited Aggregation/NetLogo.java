globals [
  radius   ;; distance of the farthest green patch from the center
]

to setup
  clear-all
  set radius 0
  ask patch 0 0
    [ set pcolor green ]
  reset-ticks
end

to go
  ;; stop when we get near the edge of the world
  if radius >= max-pxcor - 3
    [ stop ]
  ;; make new turtles, up to a maximum controlled by the MAX-PARTICLES
  ;; slider; also check clock so we don't make too many turtles too
  ;; soon, otherwise we get a big green clump at the center (only happens
  ;; USE-WHOLE-WORLD? is false)
  while [count turtles < max-particles and
         count turtles < ticks]
    [ make-new-turtle ]
  ;; now move the turtles
  ask turtles
    [ wander
      if any? neighbors with [pcolor = green]
        [ set pcolor green
          ;; increase radius if appropriate
          if distancexy 0 0 > radius
            [ set radius distancexy 0 0 ]
          die ]
      ;; kill turtles that wander too far away from the center
      if not use-whole-world? and distancexy 0 0 > radius + 3
        [ die ] ]
  ;; advance clock
  tick
end

to make-new-turtle
  ;; each new turtle starts its random walk from a position
  ;; a bit outside the current radius and facing the center
  create-turtles 1
    [ set color red
      set size 3  ;; easier to see
      setxy 0 0
      ifelse use-whole-world?
        [ jump max-pxcor ]
        [ jump radius + 1.5 ]
      rt 180 ]
end

to wander   ;; turtle procedure
  ;; the WIGGLE-ANGLE slider makes our path straight or wiggly
  rt random-float wiggle-angle - random-float wiggle-angle
  ;; kill off particles that reach the edge
  if not can-move? 1 [ die ]
  ;; move
  fd 1
end


; Copyright 1997 Uri Wilensky.
; See Info tab for full copyright and license.
