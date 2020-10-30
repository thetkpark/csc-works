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

    const myMap = new google.maps.Map(document.getElementById('mapDisplay'), mapOptions)
    const shop = {
        position: {
            lat: 13.746360,
            lng: 100.534640
        },
        title: 'Best Gold Fish @ Siam Paragon'
    }
    const myMarker = new google.maps.Marker(shop)
    myMarker.setMap(myMap)

    const shopList = [
        {
            position: { lat: 13.697667, lng: 100.537583 },
            title: 'Best Gold Fish @ Central Rama 3'
        },
        {
            position: { lat: 13.646854, lng: 100.68014 },
            title: 'Best Gold Fish @ Mega Bangna'
        },
        {
            position: { lat: 18.793268, lng: 98.984972 },
            title: 'Best Gold Fish @ Chiangmai'
        },
        {
            position: { lat: 35.681077, lng: 139.768792 },
            title: 'Best Gold Fish @ Tokyo'
        }
    ]

    shopList.forEach(shop => {
        const marker = new google.maps.Marker(shop) 
        marker.setMap(myMap)
    })

}