(ns acey-ducey.core
  (:gen-class))


(defn get-random
  [n]
  (sort (take n (distinct (take 5 (repeatedly (partial rand-int 10)))))))

(defn play
  [[minimum maximum] money]
  (let [number (first (get-random 1))]
    (println (str "Ha sido un " number))
    (if (and (> number minimum) (< number maximum))
      (do
        (println "YOU WIN")
        (+ money 10))
      (do
        (println "YOU LOSE")
        (- money 10)))))

(defn start
  [money]
  (when (< money 10)
    (println "Go home you poor bastard, you LOST ALL!!")
    (System/exit 0))
  (let [numbers (get-random 2)]
    (println (str "The numbers are: " numbers))
    (println (str "You have " money "$!"))
    (println "Do you want to play? (y/n/q)")
    (let [input (read-line)]
      (cond
        (= input "q") (System/exit 0)
        (= input "n")
        (do
          (println "You chicken out! Lost 2$ for it.")
          (let [money (- money 2)]
            (start money)))
        (= input "y") (do
                        (let [money (play numbers money)]
                          (start money)))
        :else (do
                (println "not a valid option")
                (start money))))))

(defn -main
  [& args]
  (println "WELCOME TO THE WORLD OF TOMORROW!!!")
  (println "THIS IS ACEY DUCEY, A GAME FROM THE FUTURE")
  (println "THAT YOU CAN START PLAYING NOW!!!")
  (println)
  (let [money 100]
    (start money)))
