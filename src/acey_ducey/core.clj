(ns acey-ducey.core
  (:gen-class))


(defn get-random
  [n]
    (sort (take n (distinct (take 5 (repeatedly (partial rand-int 10)))))))

(defn play
  [[minimum maximum]]
  (let [number (first (get-random 1))]
    (println (str "Ha sido un " number))
    (if (and (> number minimum) (< number maximum))
      (println "YOU WIN")
      (println "YOU LOSE"))))

(defn start
  []
  (let [numbers (get-random 2)]
    (println (str "The numbers are: " numbers))
    (println "Do you want to play? (y/n/q)")
    (let [input (read-line)]
      (when (= input "q")
        (System/exit 0))
      (when (= input "n")
        (println "ok, let's try again"))
      (when (= input "y")
        (play numbers))
      (start))))

(defn -main
  [& args]
  (println "WELCOME TO THE WORLD OF TOMORROW!!!")
  (println "THIS IS ACEY DUCEY, A GAME FROM THE FUTURE")
  (println "THAT YOU CAN START PLAYING NOW!!!")
  (println)
  (start))
