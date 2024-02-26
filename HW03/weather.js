function toCelsius() {
    // grabs the input from the user
    let input =  document.getElementById("temperature").value;
    
    // Check if the input is a valid number
    if (!isNaN(input)) {
        // converts the temperature to Celsius
        let celsius = (input - 32) * 5/9;

        // show back to the user, on the <span> element
        document.getElementById("result").innerText = celsius;

        // makes the div visible
        document.getElementById("result-parent").style.visibility = "visible";
    } else {
        // Display warning message for invalid input
        document.getElementById("result").innerHTML = "<b style='color: red;'>Please input a valid number!</b>";
        // make the div visible
        document.getElementById("result-parent").style.visibility = "visible";
    }
}

