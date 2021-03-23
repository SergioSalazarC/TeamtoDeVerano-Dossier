LATEXCMD = pdflatex -shell-escape
export max_print_line = 1048576

.PHONY: help
help:
	@echo "This makefile builds URJC (URJC ACM Contest Template Library)"
	@echo ""
	@echo "Available commands are:"
	@echo "	make fast	- to build the PDF, quickly (only runs LaTeX once)"
	@echo "	make URJC	- to build the PDF"
	@echo "	make test	- to run the fuzzy tests"
	@echo "	make clean	- to clean up the build process"
	@echo "	make veryclean	- to clean up and remove kactl.pdf"
	@echo "	make help	- to show this information"
	@echo ""
	@echo "For more information see the file 'doc/README'"

.PHONY: fast
fast:
	cd build && $(LATEXCMD) URJCv3.tex </dev/null
	cp build/URJC.pdf URJC.pdf

.PHONY: URJC
URJC: test-session.pdf
	cd build && $(LATEXCMD) URJCv3.tex && $(LATEXCMD) URJC.tex
	cp build/URJC.pdf URJC.pdf

.PHONY: print
print: URJC
	cd build && $(LATEXCMD) print.tex && $(LATEXCMD) print.tex

.PHONY: test
test:
	python fuzz-tests/fuzz.py

.PHONY: clean
clean:
	cd build && rd -f kactl.aux kactl.log kactl.tmp kactl.toc URJC.pdf kactl.ptc

.PHONY: veryclean
veryclean: clean
	rd -f URJC.pdf test-session.pdf

test-session.pdf: content/test-session/chapter.tex
	cd build && $(LATEXCMD) test-session.tex
	cp build/test-session.pdf test-session.pdf
