(ns learningclojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; (do
;;   (println "Hello")
;;   (println "World"))

"hello"   ;; string
\e        ;; character
0xBC      ;; hex
#"[0-9]+" ;; regex
\newline  ;; special character

nil         ;; null val
true false  ;; bool
:alpha      ;; keyword

'(1 2 3)      ;; list
[1 2 3]       ;; vector
#{1 2 3}      ;; set
{:a 1, :b 2}  ;; map

(+ 1 2)

;; Defining Functions
(defn greet  [name]  (str "Hello, " name) )

;; Multi-arity Functions
;; Each arity is a list ([param*] body*) and one arity can invoke another
(defn messenger 
  ([] (messenger "Hello world"))
  ([msg] (println msg))
)

;; Variadic Functions
;; Functions may also define a variable number of parameters - this is known as a variadic function

(defn hello [greeting & who]
  (println greeting who))

;; Anonymous function

(fn [msg] (println msg))

;; Immediately Invoke an anonymouse func
((fn [message] (println message)) "Hello world!")

;; Clojure only has expressions
(defn f [name] (str "Hello " name))

(def f (fn [name] str "Hello " name))

;; The above two are equivalent

;; Anonymous function syntax sugar
;; Equivalent to: (fn [x] (+ 6 x))
#(+ 6 %)

;; Equivalent to: (fn [x y] (+ x y))
#(+ %1 %2)

;; Equivalent to: (fn [x y & zs] (println x y zs))
#(println %1 %2 %&)