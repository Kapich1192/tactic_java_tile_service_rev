
//Конфигурация системы
let map;
let marker = L.marker([55.9469, 37.4879]);
let osmUrl = 'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
let osmAttrib = '&copy; <a href="http://openstreetmap.org/copyright">OpenStreetMap</a> | &copy; <a href="">Stupor Development Tools</a>';
let osm = L.tileLayer(osmUrl, {maxZoom: 18, attribution: osmAttrib});

 let google_hybrid  = L.tileLayer('http://{s}.google.com/vt/lyrs=s,h&x={x}&y={y}&z={z}',{
        subdomains:['mt0','mt1','mt2','mt3']
    });

let current_lan = 55.946234;
let current_len = 37.487380;
let current_zoom = 14;
let current_max_zoom;
let current_min_zoom;
//Список объектов на карте
let devices = new Array();
let flights = new Array();
let flight_counter = 0;
let ma;
let mark = L.marker([current_lan, current_len]);
//Инициализация карты
function init() {
    map = new L.Map(document.getElementById("map"), {center: new L.LatLng(current_lan, current_len), zoom: current_zoom});
    drawnItems = L.featureGroup().addTo(map);
    //osm.addTo(map);
    osm.addTo(map);
    //let mark = L.marker([current_lan, current_len]).addTo(map);
    mark.bindPopup(current_lan+","+ current_len).openPopup();
    mark.addTo(map);
    map.addEventListener('click',function (e) {
    //                let cursor_longitude = document.getElementById('cursor_longitude');
     //               let cursor_latitude = document.getElementById('cursor_latitude');

    //                if(this.coordinate_type == 0) {
                        let temp_longitude = e.latlng.lng + '';
                        let temp_latitude = e.latlng.lat + '';
                         //  if(marker != null) {
//                            map.removeLayer(marker);
//                            mark = null;
//                           }
 //   if(mark == null){
        //L.marker([e.latlng.lat,e.latlng.lng]).addTo(map);
//    } else {
        mark.bindPopup("Широта - "+e.latlng.lat + "<br>Долгота - " +e.latlng.lng).openPopup();
        mark.setLatLng([e.latlng.lat, e.latlng.lng]);
//    }
    //                    let tl = temp_longitude.substring(0,10);
    //                    cursor_longitude.innerHTML = tl;
    //
    //
    //                    let tla = temp_latitude.substring(0,10);
    //                    cursor_latitude.innerHTML = tla;
    //
    //                } else {
    //                                    let temp_longitude = e.latlng.lng +'';
    //                                    let temp_latitude = e.latlng.lat +'';
    //
    //                                    let mss = WGS84ToSK42Meters(temp_latitude, temp_longitude, 1);
    //                                    let tl = (mss[1] + "").substring(0,10);
    //                                    cursor_longitude.innerHTML = tl;
    //
    //                                    let tla = (mss[0] + "").substring(0,10);
    //                                    cursor_latitude.innerHTML = tla;
    //
    //
    //
    //
    //                }
            });
}

