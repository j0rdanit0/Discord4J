/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package discord4j.common.json.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nullable;

public class EmojiResponse {

	private String id;
	private String name;
	private String[] roles;
	@Nullable
	private UserResponse user;
	@JsonProperty("require_colons")
	private boolean requireColons;
	private boolean managed;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String[] getRoles() {
		return roles;
	}

	@Nullable
	public UserResponse getUser() {
		return user;
	}

	public boolean isRequireColons() {
		return requireColons;
	}

	public boolean isManaged() {
		return managed;
	}
}
