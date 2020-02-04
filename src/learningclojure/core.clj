(ns learningclojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(do
  (println "Hello")
  (println "World"))

"hello"   ; string
\e        ; character
0xBC      ; hex
#"[0-9]+" ; regex
\newline  ; special character

nil         ; null val
true false  ; bool
:alpha      ; keyword

'(1 2 3)      ; list
[1 2 3]       ; vector
#{1 2 3}      ; set
{:a 1, :b 2}  ; map

(+ 1 2)

; Defining Functions
(defn greet  [name]  (str "Hello, " name) )

; Multi-arity Functions
(defn messenger 
  ([] (messenger "Hello world"))
  ([msg] (println msg))
)

; Variadic Functions
; Functions may also define a variable number of parameters - this is known as a variadic function

(defn hello [greeting & who]
  (println greeting who))

; Anonymous function
((fn [message] (println message)) "Hello world!")