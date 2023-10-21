URL de la página de pruebas mercuryTours: https://demo.guru99.com/test/newtours/

1. Localizadores/Estrategias de Localización:
1- By.id(“id”)
2- By.name("name")
3- By.className(“class”)
4- By.tagName("tag")
5- By.linkText("string")
6- By.partialLinkText("string")
7- By.cssSelector("input[name='q']")
8- By.xpath("//input[@name='q']")
9- JavaScript

2. Tipos de esperas:

- Esperas implícita: Expecificamos el tiempo de espera hasta que aparezca el elemento que necesitamos, si en el tiempo
indicado no aparece el elemento, webdriver lanzará una segunda búsqueda, si aun así no lo encuentra, nos mandará una null exception. 
El tiempo de espera es asociado es 0 y este tiempo se asocia al objeto webdriver, por lo que tendrá la espera en cada elemento que busque

- Espera explícita:
(Thread.sleep(2000))
Establece un tiempo fijo de espera

WebDriverWait y ExpectedCondition: Son las más recomendables de usar ya que nos dan la posibilidad de establecer
un tiempo máx de espera, pero realizan las consultas cada 500 ms, por lo que si la condición ha ocurrido, pasará al siguiente paso, 
si despues del tiempo de espera no ha ocurrido, lanzara una timeOutException

Fluent Waits, que heredan de la clase wait, nos permiten establecer un tiempo máx de espera, pero nos dan mayor control ya que nos
permite personalizar los tiempos de consulta a la página (polling time). También nos permite ignorar algunas excepciones especificas.


