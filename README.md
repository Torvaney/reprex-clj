# reprex

[![travis status](https://travis-ci.org/Torvaney/reprex-clj.svg?branch=master)](https://travis-ci.org/Torvaney/reprex-clj)
[![code coverage](https://codecov.io/gh/Torvaney/reprex-clj/branch/master/graph/badge.svg)](https://codecov.io/github/Torvaney/reprex-clj?branch=master)

Based on the `tidyverse/reprex` [package for R](https://github.com/tidyverse/reprex).

Prepare reprexes for posting to [GitHub
issues](https://guides.github.com/features/issues/),
[StackOverflow](https://stackoverflow.com/questions/tagged/r), or [Slack
snippets](https://get.slack.help/hc/en-us/articles/204145658-Create-a-snippet).
What is a `reprex`? It’s a **repr**oducible **ex**ample, as coined by
[Romain
Francois](https://twitter.com/romain_francois/status/530011023743655936).

# Usage

Use the `reprex` function to easily capture expressions and their outputs:

~~~
user=> (require '[reprex.core :refer [reprex]])
nil
user=> (->> (reprex (+ 1 1) (* 5 5)) println)
``` clojure
(+ 1 1)
; => 2

(* 5 5)
; => 25
```

Created by [reprex](https://github.com/Torvaney/reprex-clj)
nil
~~~

This GitHub-flavored Markdown is the ready to be copied and pasted. When
rendered, it would look like this:

``` clojure
(+ 1 1)
; => 2

(* 5 5)
; => 25
```
