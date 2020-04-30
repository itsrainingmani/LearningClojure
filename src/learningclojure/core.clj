(ns learningclojure.core
  (:gen-class)
  (require [clojure.repl :refer :all])
  (require [clojure.string :as str]))

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
;;    name   params            body
(defn greet  [name]  (str "Hello my sweet, " name))

;; Multi-arity Functions
;; Each arity is a list ([param*] body*) and one arity can invoke another
(defn messenger
  ([] (messenger "Hello World"))
  ([msg] (println msg)))

;; Variadic Functions
;; Functions may also define a variable number of parameters - this is known as a variadic function
(defn hello [greeting & who]
  (println greeting who))

;; Anonymous function can be created with fn
;;      params           body
;; (fn [message] (println message))

;; Immediately Invoke an Anonymous Func
((fn [message] (println message)) "Immediately invoked Hello World!")

;; Most languages have statements and expressions
;; Statements imperatively do something and do not
;; return a value.
;; Clojure has only expressions that return a value.

;; defn vs fn
;; Think of defn as a contraction of def and fn
;; fn defines a function and defn binds it to a name
(defn ex [name] (str "Hello " name))

(def f (fn [name] str "Hello " name))
;; The above two are equivalent

;; Anonymous function syntax sugar
;; Equivalent to: (fn [x] (+ 6 x))
;; #(+ 6 %)

;; Equivalent to: (fn [x y] (+ x y))
;; #(+ %1 %2)

;; Equivalent to: (fn [x y & zs] (println x y zs))
;; #(println %1 %2 %&)

(def pr-sum #(pr %&)) ;; ~= (def pr-sum (fn [&z] (pr z)))

;; Applying Functions - The apply function invokes a function with 0 or more arguments

;; (apply f '(1 2 3 4))
;; (apply f 1 '(2 3 4))
;; (apply f 1 2 '(3 4))
;; (apply f 1 2 3 '(4)) ;; The final arg must be a sequence

;; All 4 are equivalent to (f 1 2 3 4)

;; Locals and Closures
;; 'let' binds symbols to values in a "lexical scope". A lexical scope creates a new context for names, nested inside the surrounding context.

;;       bindings     name exists here
;; (let [name value] (code that uses name))

;; (let [x 1
;;       y 2]
;;   (+ x y))

(defn closure-test [msg]
  (let [a "Hey"
        b "there, "
        c (str/capitalize msg)]
    (println a b c)
  ) ;; end of let scope
  ) ;; end of function

;; Closures
(defn messenger-builder [greeting]
  (fn [who] (println greeting who))) ; closes over greeting

;; greeting provided here, then goes out of scope
(def hello-er (messenger-builder "Inside Closure"))

;; greeting value still available because hello-er is a closure
(hello-er "Inner Function")

;; Test your knowledge II

;; 1) Define a function greet that takes no args and prints "Hello"
(defn greet-test [] (println "Hello"))

;; 2) Redefine greet using def. First with fn and then with #() reader macro
(def greet-test-1 (fn [] (println "Hello")))
(def greet-test-2 #(println "Hello"))

;; 3) Define a function greeting which:
;; * Given no args, returns "Hello, World!"
;; * Given one arg x, returns "Hello, x!"
;; * Given 2 args x and y, returns "x, y!"
(defn greeting
  ([] (greeting "Hello" "World"))
  ([x] (greeting "Hello" x))
  ([x y] (str x ", " y "!")))

;; for testing
(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

;; 4) Define a function do-nothing, which takes a single arg and returns it
(defn do-nothing [x] x)

;; 5) Define a function always-thing, which takes any number of args,
;; ignores them all and returns 100
(defn always-thing [& xs] 100)

;; Cannot nest Anonymous functions since that would create ambiguity as the parameters are not named

;; This is valid
(def t #(* 2 %1))
#(t 10)

;; This is not since the anon function is nested
;; #((#(* 2 %1)) 10)

;; Using an anonymous function inside a let block
(let [t 
      #(* 2 %1)] ;; Binds #(* 2 %1) to t in the lexical scope
  (t 10))
