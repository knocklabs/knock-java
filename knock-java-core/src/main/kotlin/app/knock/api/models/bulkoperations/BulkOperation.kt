// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.bulkoperations

import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A bulk operation entity. */
class BulkOperation
private constructor(
    private val id: JsonField<String>,
    private val _typename: JsonField<String>,
    private val estimatedTotalRows: JsonField<Long>,
    private val insertedAt: JsonField<OffsetDateTime>,
    private val name: JsonField<String>,
    private val processedRows: JsonField<Long>,
    private val status: JsonField<Status>,
    private val successCount: JsonField<Long>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val completedAt: JsonField<OffsetDateTime>,
    private val errorCount: JsonField<Long>,
    private val errorItems: JsonField<List<ErrorItem>>,
    private val failedAt: JsonField<OffsetDateTime>,
    private val progressPath: JsonField<String>,
    private val startedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("__typename") @ExcludeMissing _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("estimated_total_rows")
        @ExcludeMissing
        estimatedTotalRows: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("inserted_at")
        @ExcludeMissing
        insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("processed_rows")
        @ExcludeMissing
        processedRows: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("success_count")
        @ExcludeMissing
        successCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("completed_at")
        @ExcludeMissing
        completedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("error_count") @ExcludeMissing errorCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("error_items")
        @ExcludeMissing
        errorItems: JsonField<List<ErrorItem>> = JsonMissing.of(),
        @JsonProperty("failed_at")
        @ExcludeMissing
        failedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("progress_path")
        @ExcludeMissing
        progressPath: JsonField<String> = JsonMissing.of(),
        @JsonProperty("started_at")
        @ExcludeMissing
        startedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        _typename,
        estimatedTotalRows,
        insertedAt,
        name,
        processedRows,
        status,
        successCount,
        updatedAt,
        completedAt,
        errorCount,
        errorItems,
        failedAt,
        progressPath,
        startedAt,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the bulk operation.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The typename of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * The estimated total number of rows to process.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun estimatedTotalRows(): Long = estimatedTotalRows.getRequired("estimated_total_rows")

    /**
     * Timestamp when the resource was created.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /**
     * The name of the bulk operation.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The number of rows processed so far.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun processedRows(): Long = processedRows.getRequired("processed_rows")

    /**
     * The status of the bulk operation.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The number of successful operations.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun successCount(): Long = successCount.getRequired("success_count")

    /**
     * The timestamp when the resource was last updated.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    /**
     * Timestamp when the bulk operation was completed.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun completedAt(): Optional<OffsetDateTime> = completedAt.getOptional("completed_at")

    /**
     * The number of failed operations.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun errorCount(): Optional<Long> = errorCount.getOptional("error_count")

    /**
     * A list of items that failed to be processed.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun errorItems(): Optional<List<ErrorItem>> = errorItems.getOptional("error_items")

    /**
     * Timestamp when the bulk operation failed.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun failedAt(): Optional<OffsetDateTime> = failedAt.getOptional("failed_at")

    /**
     * The URI to the bulk operation's progress.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun progressPath(): Optional<String> = progressPath.getOptional("progress_path")

    /**
     * Timestamp when the bulk operation was started.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun startedAt(): Optional<OffsetDateTime> = startedAt.getOptional("started_at")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /**
     * Returns the raw JSON value of [estimatedTotalRows].
     *
     * Unlike [estimatedTotalRows], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("estimated_total_rows")
    @ExcludeMissing
    fun _estimatedTotalRows(): JsonField<Long> = estimatedTotalRows

    /**
     * Returns the raw JSON value of [insertedAt].
     *
     * Unlike [insertedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inserted_at")
    @ExcludeMissing
    fun _insertedAt(): JsonField<OffsetDateTime> = insertedAt

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [processedRows].
     *
     * Unlike [processedRows], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("processed_rows")
    @ExcludeMissing
    fun _processedRows(): JsonField<Long> = processedRows

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [successCount].
     *
     * Unlike [successCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success_count")
    @ExcludeMissing
    fun _successCount(): JsonField<Long> = successCount

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [completedAt].
     *
     * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completed_at")
    @ExcludeMissing
    fun _completedAt(): JsonField<OffsetDateTime> = completedAt

    /**
     * Returns the raw JSON value of [errorCount].
     *
     * Unlike [errorCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error_count") @ExcludeMissing fun _errorCount(): JsonField<Long> = errorCount

    /**
     * Returns the raw JSON value of [errorItems].
     *
     * Unlike [errorItems], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error_items")
    @ExcludeMissing
    fun _errorItems(): JsonField<List<ErrorItem>> = errorItems

    /**
     * Returns the raw JSON value of [failedAt].
     *
     * Unlike [failedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failed_at") @ExcludeMissing fun _failedAt(): JsonField<OffsetDateTime> = failedAt

    /**
     * Returns the raw JSON value of [progressPath].
     *
     * Unlike [progressPath], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("progress_path")
    @ExcludeMissing
    fun _progressPath(): JsonField<String> = progressPath

    /**
     * Returns the raw JSON value of [startedAt].
     *
     * Unlike [startedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("started_at")
    @ExcludeMissing
    fun _startedAt(): JsonField<OffsetDateTime> = startedAt

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BulkOperation].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .estimatedTotalRows()
         * .insertedAt()
         * .name()
         * .processedRows()
         * .status()
         * .successCount()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkOperation]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var estimatedTotalRows: JsonField<Long>? = null
        private var insertedAt: JsonField<OffsetDateTime>? = null
        private var name: JsonField<String>? = null
        private var processedRows: JsonField<Long>? = null
        private var status: JsonField<Status>? = null
        private var successCount: JsonField<Long>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var completedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var errorCount: JsonField<Long> = JsonMissing.of()
        private var errorItems: JsonField<MutableList<ErrorItem>>? = null
        private var failedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var progressPath: JsonField<String> = JsonMissing.of()
        private var startedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(bulkOperation: BulkOperation) = apply {
            id = bulkOperation.id
            _typename = bulkOperation._typename
            estimatedTotalRows = bulkOperation.estimatedTotalRows
            insertedAt = bulkOperation.insertedAt
            name = bulkOperation.name
            processedRows = bulkOperation.processedRows
            status = bulkOperation.status
            successCount = bulkOperation.successCount
            updatedAt = bulkOperation.updatedAt
            completedAt = bulkOperation.completedAt
            errorCount = bulkOperation.errorCount
            errorItems = bulkOperation.errorItems.map { it.toMutableList() }
            failedAt = bulkOperation.failedAt
            progressPath = bulkOperation.progressPath
            startedAt = bulkOperation.startedAt
            additionalProperties = bulkOperation.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the bulk operation. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The typename of the schema. */
        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** The estimated total number of rows to process. */
        fun estimatedTotalRows(estimatedTotalRows: Long) =
            estimatedTotalRows(JsonField.of(estimatedTotalRows))

        /**
         * Sets [Builder.estimatedTotalRows] to an arbitrary JSON value.
         *
         * You should usually call [Builder.estimatedTotalRows] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun estimatedTotalRows(estimatedTotalRows: JsonField<Long>) = apply {
            this.estimatedTotalRows = estimatedTotalRows
        }

        /** Timestamp when the resource was created. */
        fun insertedAt(insertedAt: OffsetDateTime) = insertedAt(JsonField.of(insertedAt))

        /**
         * Sets [Builder.insertedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.insertedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun insertedAt(insertedAt: JsonField<OffsetDateTime>) = apply {
            this.insertedAt = insertedAt
        }

        /** The name of the bulk operation. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The number of rows processed so far. */
        fun processedRows(processedRows: Long) = processedRows(JsonField.of(processedRows))

        /**
         * Sets [Builder.processedRows] to an arbitrary JSON value.
         *
         * You should usually call [Builder.processedRows] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun processedRows(processedRows: JsonField<Long>) = apply {
            this.processedRows = processedRows
        }

        /** The status of the bulk operation. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The number of successful operations. */
        fun successCount(successCount: Long) = successCount(JsonField.of(successCount))

        /**
         * Sets [Builder.successCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.successCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun successCount(successCount: JsonField<Long>) = apply { this.successCount = successCount }

        /** The timestamp when the resource was last updated. */
        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** Timestamp when the bulk operation was completed. */
        fun completedAt(completedAt: OffsetDateTime?) =
            completedAt(JsonField.ofNullable(completedAt))

        /** Alias for calling [Builder.completedAt] with `completedAt.orElse(null)`. */
        fun completedAt(completedAt: Optional<OffsetDateTime>) =
            completedAt(completedAt.getOrNull())

        /**
         * Sets [Builder.completedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun completedAt(completedAt: JsonField<OffsetDateTime>) = apply {
            this.completedAt = completedAt
        }

        /** The number of failed operations. */
        fun errorCount(errorCount: Long) = errorCount(JsonField.of(errorCount))

        /**
         * Sets [Builder.errorCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun errorCount(errorCount: JsonField<Long>) = apply { this.errorCount = errorCount }

        /** A list of items that failed to be processed. */
        fun errorItems(errorItems: List<ErrorItem>) = errorItems(JsonField.of(errorItems))

        /**
         * Sets [Builder.errorItems] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorItems] with a well-typed `List<ErrorItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun errorItems(errorItems: JsonField<List<ErrorItem>>) = apply {
            this.errorItems = errorItems.map { it.toMutableList() }
        }

        /**
         * Adds a single [ErrorItem] to [errorItems].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addErrorItem(errorItem: ErrorItem) = apply {
            errorItems =
                (errorItems ?: JsonField.of(mutableListOf())).also {
                    checkKnown("errorItems", it).add(errorItem)
                }
        }

        /** Timestamp when the bulk operation failed. */
        fun failedAt(failedAt: OffsetDateTime?) = failedAt(JsonField.ofNullable(failedAt))

        /** Alias for calling [Builder.failedAt] with `failedAt.orElse(null)`. */
        fun failedAt(failedAt: Optional<OffsetDateTime>) = failedAt(failedAt.getOrNull())

        /**
         * Sets [Builder.failedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun failedAt(failedAt: JsonField<OffsetDateTime>) = apply { this.failedAt = failedAt }

        /** The URI to the bulk operation's progress. */
        fun progressPath(progressPath: String) = progressPath(JsonField.of(progressPath))

        /**
         * Sets [Builder.progressPath] to an arbitrary JSON value.
         *
         * You should usually call [Builder.progressPath] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun progressPath(progressPath: JsonField<String>) = apply {
            this.progressPath = progressPath
        }

        /** Timestamp when the bulk operation was started. */
        fun startedAt(startedAt: OffsetDateTime?) = startedAt(JsonField.ofNullable(startedAt))

        /** Alias for calling [Builder.startedAt] with `startedAt.orElse(null)`. */
        fun startedAt(startedAt: Optional<OffsetDateTime>) = startedAt(startedAt.getOrNull())

        /**
         * Sets [Builder.startedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun startedAt(startedAt: JsonField<OffsetDateTime>) = apply { this.startedAt = startedAt }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [BulkOperation].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .estimatedTotalRows()
         * .insertedAt()
         * .name()
         * .processedRows()
         * .status()
         * .successCount()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BulkOperation =
            BulkOperation(
                checkRequired("id", id),
                checkRequired("_typename", _typename),
                checkRequired("estimatedTotalRows", estimatedTotalRows),
                checkRequired("insertedAt", insertedAt),
                checkRequired("name", name),
                checkRequired("processedRows", processedRows),
                checkRequired("status", status),
                checkRequired("successCount", successCount),
                checkRequired("updatedAt", updatedAt),
                completedAt,
                errorCount,
                (errorItems ?: JsonMissing.of()).map { it.toImmutable() },
                failedAt,
                progressPath,
                startedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BulkOperation = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        estimatedTotalRows()
        insertedAt()
        name()
        processedRows()
        status().validate()
        successCount()
        updatedAt()
        completedAt()
        errorCount()
        errorItems().ifPresent { it.forEach { it.validate() } }
        failedAt()
        progressPath()
        startedAt()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: KnockInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (_typename.asKnown().isPresent) 1 else 0) +
            (if (estimatedTotalRows.asKnown().isPresent) 1 else 0) +
            (if (insertedAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (processedRows.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (successCount.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (completedAt.asKnown().isPresent) 1 else 0) +
            (if (errorCount.asKnown().isPresent) 1 else 0) +
            (errorItems.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (failedAt.asKnown().isPresent) 1 else 0) +
            (if (progressPath.asKnown().isPresent) 1 else 0) +
            (if (startedAt.asKnown().isPresent) 1 else 0)

    /** The status of the bulk operation. */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val QUEUED = of("queued")

            @JvmField val PROCESSING = of("processing")

            @JvmField val COMPLETED = of("completed")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            QUEUED,
            PROCESSING,
            COMPLETED,
            FAILED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            QUEUED,
            PROCESSING,
            COMPLETED,
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                QUEUED -> Value.QUEUED
                PROCESSING -> Value.PROCESSING
                COMPLETED -> Value.COMPLETED
                FAILED -> Value.FAILED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws KnockInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                QUEUED -> Known.QUEUED
                PROCESSING -> Known.PROCESSING
                COMPLETED -> Known.COMPLETED
                FAILED -> Known.FAILED
                else -> throw KnockInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws KnockInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { KnockInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Status = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: KnockInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class ErrorItem
    private constructor(
        private val id: JsonField<String>,
        private val collection: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("collection")
            @ExcludeMissing
            collection: JsonField<String> = JsonMissing.of(),
        ) : this(id, collection, mutableMapOf())

        /**
         * Unique identifier for the object.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The collection this object belongs to.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun collection(): Optional<String> = collection.getOptional("collection")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [collection].
         *
         * Unlike [collection], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("collection")
        @ExcludeMissing
        fun _collection(): JsonField<String> = collection

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ErrorItem].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ErrorItem]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var collection: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(errorItem: ErrorItem) = apply {
                id = errorItem.id
                collection = errorItem.collection
                additionalProperties = errorItem.additionalProperties.toMutableMap()
            }

            /** Unique identifier for the object. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The collection this object belongs to. */
            fun collection(collection: String?) = collection(JsonField.ofNullable(collection))

            /** Alias for calling [Builder.collection] with `collection.orElse(null)`. */
            fun collection(collection: Optional<String>) = collection(collection.getOrNull())

            /**
             * Sets [Builder.collection] to an arbitrary JSON value.
             *
             * You should usually call [Builder.collection] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun collection(collection: JsonField<String>) = apply { this.collection = collection }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [ErrorItem].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ErrorItem =
                ErrorItem(checkRequired("id", id), collection, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ErrorItem = apply {
            if (validated) {
                return@apply
            }

            id()
            collection()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: KnockInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) + (if (collection.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ErrorItem && id == other.id && collection == other.collection && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, collection, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ErrorItem{id=$id, collection=$collection, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BulkOperation && id == other.id && _typename == other._typename && estimatedTotalRows == other.estimatedTotalRows && insertedAt == other.insertedAt && name == other.name && processedRows == other.processedRows && status == other.status && successCount == other.successCount && updatedAt == other.updatedAt && completedAt == other.completedAt && errorCount == other.errorCount && errorItems == other.errorItems && failedAt == other.failedAt && progressPath == other.progressPath && startedAt == other.startedAt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, estimatedTotalRows, insertedAt, name, processedRows, status, successCount, updatedAt, completedAt, errorCount, errorItems, failedAt, progressPath, startedAt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BulkOperation{id=$id, _typename=$_typename, estimatedTotalRows=$estimatedTotalRows, insertedAt=$insertedAt, name=$name, processedRows=$processedRows, status=$status, successCount=$successCount, updatedAt=$updatedAt, completedAt=$completedAt, errorCount=$errorCount, errorItems=$errorItems, failedAt=$failedAt, progressPath=$progressPath, startedAt=$startedAt, additionalProperties=$additionalProperties}"
}
