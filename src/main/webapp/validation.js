   function  validateSoldBought() {
                        var bought = document.getElementById("bought").value;
                        var sold = document.getElementById("sold").value;
                        if (parseInt(bought, 10) < parseInt(sold, 10)) {
                            var mesg = "bought value should be greater than sold Please enter valid data. ";
                            document.getElementById("invalid").innerHTML = mesg;
                            return false;
                        } else {
                            var mesg = " ";
                            document.getElementById("invalid").innerHTML = mesg;
                            return  true;
                        }
                    }

//            bought.onblur = validateSoldBought;
//            sold.onblur = validateSoldBought;

                    function clearFeild() {
                        document.getElementById("bought").innerHTML = " ";
                        document.getElementById("sold").innerHTML = " ";
                        document.getElementById("item").innerHTML = " ";
                    }
                    function mysubmit() { 
                        if (validateSoldBought() == true) {
                            return true;
                        }
                        return false;
                    }