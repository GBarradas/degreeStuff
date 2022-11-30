classes/j/A.class: src/j/A.java classes/j/B.class
	javac -d classes -classpath classes src/j/A.java

classes/j/B.class: src/j/B.java
	javac -d classes src/j/B.java


clean:
	rm -rf classes/* demo.jar

demo.jar: classes/j/A.class
	@echo "a fazer o jar..."
	# nome do JAR: argumento f e o nome "demo.jar"
	# definir o conteudo para o MANIFEST: argumento m e o nome do ficheiro informacao_para_Manifest.txt
	# adicionar pasta j, dentro da pasta classes: "-C classes j"
	jar cfm demo.jar informacao_para_Manifest.txt -C classes j


run: demo.jar
	java -jar demo.jar
	## para executar outra classe: java -classpath demo.jar NOME
	## exemplo: java -classpath demo.jar j.A       # ... isto foi indicado via Manifest Main-Class

