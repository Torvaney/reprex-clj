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
user=>
~~~

This GitHub-flavored Markdown is the ready to be copied and pasted. When
rendered, it would look like this:

``` clojure
(+ 1 1)
; => 2

(* 5 5)
; => 25
```

Created by [reprex](https://github.com/Torvaney/reprex-clj)
