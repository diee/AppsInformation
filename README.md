# # Apps Information

Apps Information es una aplicación de prueba la cual muestra en una grilla diferentes aplicaciones publicadas en el App Store. Ofrece la posibilidad de filtrar la busqueda por las diferentes categorias de aplicaciones mostradas, ademas de poder ver lo detalles de cada aplicación.

### Version
1.0.0

### Screenshots
<img src="/../screenshots/screenshot_splash.png?raw=true"  height="350" >
<img src="/../screenshots/screenshot_photovideo.png?raw=true"  height="350" >
<img src="/../screenshots/screenshot_all.png?raw=true"  height="350" >


### Tech

Frameworks usados:

* [Retrofit] - Para consumir el servicio en formato JSON
* [Sugar ORM] - Para guardar la informacion en local
* [Picasso] - Para cargar las imagenes



   [Picasso]: <http://square.github.io/picasso/>
   [Retrofit]: <http://square.github.io/retrofit/>
   [Sugar ORM]: <http://satyan.github.io/sugar/>
   
### Detalles

* OnLine/OffLine: la aplicacion guarda en Base de Datos local la informacion necesaria para poder trabajar de manera offline. Por medio de un snackbar se dará aviso en caso no tener conexión
* Splash: la aplicación tiene un Splash al iniciar con una duracion de 3 segundos
* Categorias: las categorias cargadas en el spinner son obtenidas del mismo servicio que las aplicaciones, se hace un busqueda y creacion de una lista de las categorias y se quitan las duplicaciones, luego por medio de un Query de Sugar ORM se hace el filtrado correspondiente.
* Portrait: la aplicacion es forzada a solo trabajar en portrait.

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]:  <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
