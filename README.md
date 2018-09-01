# reprex

[![travis status](https://travis-ci.org/Torvaney/reprex-clj.svg?branch=master)](https://travis-ci.org/Torvaney/reprex-clj)
[![code coverage](https://codecov.io/gh/Torvaney/reprex-clj/branch/master/graph/badge.svg)](https://codecov.io/github/Torvaney/reprex-clj?branch=master)

[![](https://clojars.org/reprex/latest-version.svg)](https://clojars.org/reprex)

Prepare **repr**oducible **ex**ample (reprexes) for posting to [GitHub
issues](https://guides.github.com/features/issues/),
[StackOverflow](https://stackoverflow.com/questions/tagged/clojure), or [Slack
snippets](https://get.slack.help/hc/en-us/articles/204145658-Create-a-snippet).

This is a clojure port of the `tidyverse/reprex` [package for R](https://github.com/tidyverse/reprex).

# Usage

Use the `reprex` function to easily capture expressions and their outputs.

With no arguments, reprex will read code from the clipboard:

~~~
user=> (require '[reprex.core :refer [reprex]])
nil
user=> (println (reprex))
``` clojure
(+ 1 1)
; => 2

(* 5 5)
; => 25
```

<details><summary>Session info</summary>

```
Clojure version:
	1.8.0
Java version:
	java version "1.8.0_102"
	Java(TM) SE Runtime Environment (build 1.8.0_102-b14)
	Java HotSpot(TM) 64-Bit Server VM (build 25.102-b14, mixed mode)
```

</details>

Created by [reprex](https://github.com/Torvaney/reprex-clj)
nil
user=>
~~~

Alternatively, you can supply expressions as arguments:

```
user=> (->> (reprex (+ 1 1) (* 5 5)) println)
```

This GitHub-flavored Markdown is then ready to be copied and pasted. When
rendered, it would looks this:

``` clojure
(+ 1 1)
; => 2

(* 5 5)
; => 25
```

<details><summary>Session info</summary>

```
Clojure version:
	1.8.0
Java version:
	java version "1.8.0_102"
	Java(TM) SE Runtime Environment (build 1.8.0_102-b14)
	Java HotSpot(TM) 64-Bit Server VM (build 25.102-b14, mixed mode)
```

</details>

Created by [reprex](https://github.com/Torvaney/reprex-clj)
