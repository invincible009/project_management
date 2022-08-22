package com.sdl.project_management.utils;

import com.fasterxml.jackson.databind.JsonSerializer;

public interface PrettySerializer {
	<T> JsonSerializer<T> getSerializer();
	<T> JsonSerializer<T> getAuditSerializer();
}
