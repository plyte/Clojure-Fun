;; Matthew Jones

;; simpsons
(defn simpsons [a b n fn]
  (quot
    (*
      (+
        (fn a)
        (fn b)
        (* (reduce + (for [i (range 0 n)] (fn (+ a (* (- b a) (+ (double i) 0.5)
                                                   )
                                              )
                                          )
                      )
            )
        )
        (* (reduce + (for [i (range 0 n)] (fn (+ a (* (- b a) (quot (double i) n)
                                                   )
                                              )
                                          )
                      )
            )
        )
      )
      (- b a)
    )
    (* n 6.0)
  )
)

;; rectangular
(defn rectangular [a b n fn mode] 
  (quot 
        (* (reduce + (for [i (range 0 n)] (fn 
                                                 (+ a (quot (* (- b a) (quot (+ i (double (quot mode 2))) n)   ) n))
                                                 )
                                               )
                                             ) (- b a)) 
        n
  )
)
;; trapezium
(defn trapezium [a b n fn] 
  (quot 
        (* (+ (reduce + (for [i (range 0 n)] (fn 
                                                 (+ a (quot (* i (- b a)) n)))
                                               )
                                             ) (quot (+ (fn a) (fn b)) 2)) (- b a)) 
        n
  )
)

(defn cube [n]
  (* n n n)
)

(defn inverse [n]
  (quot 1 n)
)

(defn x [n]
  n
)

(trapezium 0.0, 1.0, 100, cube)
(rectangular 0.0, 1.0, 100, cube, 0)
(rectangular 0.0, 1.0, 100, cube, 1)
(rectangular 0.0, 1.0, 100, cube, 2)
(simpsons 0.0, 1.0, 100, cube)

(trapezium 1.0, 100.0, 1000, inverse)
(rectangular 1.0, 100.0, 1000, inverse, 0)
(rectangular 1.0, 100.0, 1000, inverse, 1)
(rectangular 1.0, 100.0, 1000, inverse, 2)
(simpsons 1.0, 100.0, 1000, inverse)

(trapezium 0, 5000.0, 5000000, x)
(rectangular 0, 5000.0, 5000000, x, 0)
(rectangular 0, 5000.0, 5000000, x, 1)
(rectangular 0, 5000.0, 5000000, x, 2)
(simpsons 0, 5000.0, 5000000, x)

(trapezium 0, 6000.0, 6000000, x)
(rectangular 0, 6000.0, 6000000, x, 0)
(rectangular 0, 6000.0, 6000000, x, 1)
(rectangular 0, 6000.0, 6000000, x, 2)
(simpsons 0, 6000.0, 6000000, x)