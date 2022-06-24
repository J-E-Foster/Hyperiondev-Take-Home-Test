<h1>Hyperiondev Code Reviews</h1>

## Software Engineering Bootcamp - Level 1, Task 22: Lists and Dictionaries
#### Student: Herp McDerp
#### Reviewer: John Foster

<h3 align="right">Overall Score: 55%</h3>

## Correctness: 3/5

Generally, your basic idea/logic is correct, and your code will meet all the requirements, **but only if you fix a few things (otherwise it will not even run)**:

* The indent level in line 2 - the code will not run until you fix this - please see comments under "Style" below.
* In line 5, the sorted() method still needs an iterable parameter (i.e. something to sort). In this case it can be a word.

I would also suggest getting into the habit of using this code at the outermost indent level before executing your functions:
```
if _name_ == '_main_':
```
This tells Python to only execute the code following the condition if the program is run directly, and not immediately when the module is imported.

While this is not really an issue in your program, it may become problematic once you import modules into each other to use their classes/functions (but maybe want to implement them differently than the original main()).

This way you also explicitly separate your class and function definitions from the main driver code that is executing them, which is always a good idea.

Please see [this link](https://stackoverflow.com/questions/40023013/tab-space-in-markdown#:~:text=In%20short%2C%20no%2C%20unless%20nested%20in%20a%20list.) for a more complete explanation.<br /><br />

## Efficiency: 5/5

Well done on choosing one of the more optimal approaches for your solution by using a dictionary and sorting the words to match the anagrams! This way you've avoided having to maintain duplicates in arrays.<br /><br /> 

## Style: 3/5

Although you have the correct idea with your indenting, you shoud **Please fix indentation in line 2 - your code won't execute until you fix this syntax error**. 
The function definition should be the first indent from the class definition, and its contents should, in turn be indented from the definition.

**Remember**:

* Indent to 4 spaces - **you used 3 spaces** (and not that you did, but preferably don't use tabs). 
* If you must use tabs, set them to 4 spaces, and if your IDE/code editor has the option, set it to insert spaces upon entering tab. 
* Also (again not that you did, but for future reference): Do **not** mix tabs and spaces in Python, this will also result in an `unindent does not match any outer indentation level` syntax error.

Please refer to the Python style guides if you get stuck:

* [PEP 8](https://peps.python.org/pep-0008/#introduction)
* [Google Python Style Guide](https://google.github.io/styleguide/pyguide.html)

**Also, please recheck your blank lines to make the code more readable**.

Although this algorithm is still short and maybe easier to read, but it becomes crucial once you have longer functions and nested functions. Generally, use them to group logical sections in the code (sparingly though), but definitely include:

* Two blank lines surrounding top level classes and functions -  in your case two blank lines inserted after line 10
* One blank line surround functions inside a class  - in your case on blank line inserted after line 1

Again, please refer to the style guides above.<br /><br />

## Documentation: 0/5

Unfortunately, **you did not include any references or comments to your code**. 

Lack of comments become problematic in terms of understanding code. In this case, it's not necessary to add comments to every line, but do outline your algorithm in a block comment above the function or class
(yet again, the official style guides above are your best friend ).

As far as references are concerned, **always include your references!** 

Remember that this is an academic course and plagarism is a serious offence. References will help you avoid plagarism, but they will also
be very useful when reviewing your own work (and they are also useful to others). You can add your references as a block comment below all the code.

For the correct referencing formats for different sources, please refer to [this guide](https://www.citethisforme.com/harvard-referencing/), which is pretty comprehensive.<br /><br />

## Overall

Overall, you did well finding a solution, **but please address the indenting and documentation issues outlined above and resubmit your code**. 

These issues may not seem like such a big deal if your main focus is on finding optimal solutions, but remember that readability, style, 
and documentation are very important considering the overall reusability and understandabilty of your code, which becomes crucial once you work in a team, 
and in the case of indenting, actually affects the execution of the code. And of course referencing is crucially important.

All in all though, the code itself is a good, clean solution! Keep it up!<br /><br />

**PS, if you have any questions on concerns, DM me on Discord and I'll be happy to help you out**.
