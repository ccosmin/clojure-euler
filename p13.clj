(def lines (clojure.string/split-lines (slurp "p13input.txt")))
(defn num-at-pos [s pos]
  (Integer. 
   (str (nth (reverse s) pos))))
(defn sum-at-pos [lines pos carry]
  (let [s (reduce + carry (map #(num-at-pos % pos) lines))]
    [(quot s 10) (rem s 10)]))


(defn mysum []
  (loop [allSum [] pos 0 carry 0]
    (if (>= pos 50) [carry allSum]
    (let [tmp (sum-at-pos lines pos carry)]
      (recur (cons (second tmp) allSum) (inc pos) (first tmp))))))

(def solution (take 10 (concat (str (first (mysum))) (apply str (second (mysum))))))
(println solution)
