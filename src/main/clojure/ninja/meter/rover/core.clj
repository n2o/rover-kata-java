(ns ninja.meter.rover.core
  (:require [clansi.core :refer [style]])
  (:gen-class)
  (:import (ninja.meter.rover RoverControl IGame)
           (java.util ArrayList)))

(defn- clj->java
  "Convert Clojure's Vector to an ArrayList."
  [v]
  (let [a (ArrayList.)]
    (doseq [e v]
      (.add a e))
    a))

(defrecord Game [world direction position]
  IGame
  (execute [this input]
    (let [jgame (RoverControl/control this input)]
      (->Game (vec (map vec (.getWorld jgame)))
              (.getRoverDirection jgame)
              [(.getRoverX jgame) (.getRoverY jgame)])))
  (getRoverX [this] (first (:position this)))
  (getRoverY [this] (second (:position this)))
  (getRoverDirection [this] (:direction this))
  (getWorld [this] (clj->java (map clj->java (:world this)))))

;; ----------------------------------------------------------------------------

(def ^:private terrain
  {"X"     (style "#" :yellow)
   "_"     " "
   "north" (style "Λ" :red :blink-slow :bright)
   "south" (style "V" :red :blink-slow :bright)
   "west"  (style "<" :red :blink-slow :bright)
   "east"  (style ">" :red :blink-slow :bright)})

(defn- print-map [game]
  (let [world (assoc-in (:world game) (:position game) (:direction game))]
    (doseq [row (mapv (partial map terrain) world)]
      (println (apply str row)))))

(defn- play [game]
  (try (loop [game (Game. (:world game) (:direction game) (:position game))]
         (print-map game)
         (println "Where do you want to move? Available commands: l, r, f, b, q")
         (let [input (read-line)]
           (when-not (= input "q")
             (recur (.execute game input)))))
       (catch Exception e
         (print-map (ex-data e))
         (println (style (.getMessage e) :red)))))

(defn- gen-row [length]
  (mapv (fn [_] (rand-nth ["_" "_" "_" "X"])) (range length)))

(defn- new-game [height length]
  (let [start-pos [(/ height 2) (/ length 2)]
        raw-world (mapv (fn [_] (gen-row length)) (range height))
        world (assoc-in raw-world start-pos "_")]
    {:world     world
     :direction "north"
     :position  start-pos}))

(defn- play-game []
  (play (new-game 24 80)))

(defn -main []
  (play-game))
