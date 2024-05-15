function clickTable(event) {
    if (event.target.localName === 'td'){
        event.target.style.border = 'solid green'
    }
}
