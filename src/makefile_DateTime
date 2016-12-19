.SUFFIXES: .class .java

PACK = homework/lab5
TARG = DateTime
JC = javac -g
JM = java -ea -jar
JR = jar -cfe

OBJ = $(PACK)/Date.class \
	$(PACK)/months.class \
	$(PACK)/Time.class \
	$(PACK)/DateTime.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

build: $(OBJ)
	$(JR) $(TARG).jar $(PACK).$(TARG) $(OBJ)

clean:
	for f in $(OBJ) ; do rm $$f ; done
	rm $(TARG).jar

$(PACK)/Date.class: $(PACK)/Date.java makefile
$(PACK)/months.class: $(PACK)/Date.java makefile
$(PACK)/Time.class: $(PACK)/Time.java makefile
$(PACK)/DateTime.class: $(PACK)/DateTime.java makefile
