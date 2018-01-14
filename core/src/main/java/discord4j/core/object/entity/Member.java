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
package discord4j.core.object.entity;

import discord4j.core.object.Presence;
import discord4j.core.object.VoiceState;
import discord4j.core.object.Snowflake;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

/** A Discord user associated to a {@link Guild}. */
public interface Member extends User {

	/**
	 * Gets the ID of the guild this user is associated to.
	 *
	 * @return The ID of the guild this user is associated to.
	 */
	Snowflake getGuildId();

	/**
	 * Requests to retrieve the guild this user is associated to.
	 *
	 * @return A {@link Mono} where, upon successful completion, emits the {@link Guild guild} this user is associated
	 * to. If an error is received, it is emitted through the {@code Mono}.
	 */
	Mono<Guild> getGuild();

	/**
	 * Gets the user's guild nickname (if one is set).
	 *
	 * @return The user's guild nickname (if one is set).
	 */
	Optional<String> getNickname();

	/**
	 * Gets the user's guild roles' IDs.
	 *
	 * @return The user's guild roles' IDs.
	 */
	Set<Snowflake> getRoleIds();

	/**
	 * Requests to retrieve the user's guild roles.
	 *
	 * @return A {@link Flux} that continually emits the user's guild {@link Role roles}. If an error is received, it is
	 * emitted through the {@code Flux}.
	 */
	Flux<Role> getRoles();

	/**
	 * Gets when the user joined the guild.
	 *
	 * @return When the user joined the guild.
	 */
	Instant getJoinTime();

	/**
	 * Gets the name that is displayed in client.
	 *
	 * @return The name that is displayed in client.
	 */
	default String getDisplayName() {
		return getNickname().orElse(getUsername());
	}

	/**
	 * Gets the <i>raw</i> nickname mention. This is the format utilized to directly mention another user (assuming the
	 * user exists in context of the mention).
	 *
	 * @return The <i>raw</i> nickname mention.
	 */
	default String getNicknameMention() {
		return "<@!" + getId().asString() + ">";
	}

	/**
	 * Requests to retrieve this user's voice state for this guild.
	 *
	 * @return A {@link Mono} where, upon successful completion, emits a {@link VoiceState voice state} for this user
	 * for this guild. If an error is received, it is emitted through the {@code Mono}.
	 */
	Mono<VoiceState> getVoiceState();

	/**
	 * Requests to retrieve the presence for this user for this guild.
	 *
	 * @return A {@link Mono} where, upon successful completion, emits a {@link Presence presence} for this user for
	 * this guild. If an error is received, it is emitted through the {@code Mono}.
	 */
	Mono<Presence> getPresence();
}
