package com.AddressService.demo.Controller;


import com.AddressService.demo.Model.Address;
import com.AddressService.demo.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fooddelivery/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> registerAddress(@RequestBody Address address){

        Address savedAddress = addressService.registerAddress(address);

        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){

        Address updatedAddress = addressService.updateAddress(address);

        return new ResponseEntity<>(updatedAddress, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Integer addressId){

        Address removedAddress = addressService.deleteAddressById(addressId);

        return new ResponseEntity<>(removedAddress, HttpStatus.OK);

    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressbyId(@PathVariable Integer addressId){

        Address address = addressService.getAddress(addressId);

        return new ResponseEntity<>(address, HttpStatus.OK);

    }

}
