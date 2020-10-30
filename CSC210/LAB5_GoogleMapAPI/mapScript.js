function mapInit () {
    const a = 5
    const b = 10
    
    document.getElementById('abc').value = a+b

    const SIT = {
        lat: 13.652950,
        lng: 100.494415
    }

    const mapOptions = {
        zoom: 12,
        center: SIT
    }

    google.maps.Map(document.getElementById('mapDisplay'), mapOptions)
}