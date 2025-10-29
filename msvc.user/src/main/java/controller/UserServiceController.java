package controller;

import org.modelmapper.ModelMapper;

import core.user.domain.User;
import core.user.domain.input.UserIn;
import core.user.domain.output.UserOut;
import core.user.service.UserService;

public class UserServiceController {

	private UserService userService;
	private ModelMapper modelMapper;
	
	public UserServiceController(UserService userService, ModelMapper modelMapper) {
		this.userService = userService;
		this.modelMapper = modelMapper;
	}
	
	public UserOut create(UserIn request) 
	{
		User user = modelMapper.map(request, User.class);
		return modelMapper.map(userService.save(user), UserOut.class);
	}
}
