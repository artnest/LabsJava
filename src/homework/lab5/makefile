JAVAC = javac
sources = DateTime.java Date.java Time.java
classes = $(sources:.java=.class)

all: $(classes)
%.class: %.java
	$(JAVAC) -d . -classpath . $<

jar: $(classes)
	jar cvf DateTime.jar $(classes)

clean:
	rm -f *.class
